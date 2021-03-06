package org.compiere.acct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.util.Check;

import com.google.common.collect.ImmutableList;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

/*
 * #%L
 * de.metas.acct.base
 * %%
 * Copyright (C) 2018 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@Value
public class FactTrxLines
{
	public static enum FactTrxLinesType
	{
		/** one debit line, one or more credit lines */
		Debit,
		/** one credit line, one or more debit lines */
		Credit,
		/** no debit or credit lines, might have zero lines */
		EmptyOrZero,
	}

	FactTrxLinesType type;
	List<FactLine> drLines;
	List<FactLine> crLines;
	List<FactLine> zeroLines;

	@Builder
	private FactTrxLines(@NonNull @Singular final List<FactLine> factLines)
	{
		final ArrayList<FactLine> drLines = new ArrayList<>();
		final ArrayList<FactLine> crLines = new ArrayList<>();
		final ArrayList<FactLine> zeroLines = new ArrayList<>();

		for (final FactLine factLine : factLines)
		{
			final boolean isDR = factLine.getAmtAcctDr().signum() != 0;
			final boolean isCR = factLine.getAmtAcctCr().signum() != 0;
			if (isDR && isCR)
			{
				throw new AdempiereException("Fact lines with both DR and CR amounts set are not allowed: " + factLine);
			}
			else if (!isDR && !isCR)
			{
				// skip zero lines, they are pointless
				zeroLines.add(factLine);
			}
			else if (isDR)
			{
				drLines.add(factLine);
			}
			else // if (isCR)
			{
				crLines.add(factLine);
			}
		}

		// https://github.com/metasfresh/metasfresh/issues/4147
		// if
		// * all not-zero lines are in dr and sum up to zero
		// * and we have one zero line,
		// then move that zero-line to cr
		// ..likewise for cr
		if (zeroLines.size() == 1)
		{
			if (drLines.isEmpty())
			{
				final BigDecimal crLineSum = crLines.stream()
						.map(FactLine::getAmtAcctCr)
						.reduce(BigDecimal.ZERO, BigDecimal::add);
				if (crLineSum.signum() == 0)
				{
					drLines.add(zeroLines.get(0));
					zeroLines.clear();
				}
			}
			else if (crLines.isEmpty())
			{
				final BigDecimal drLineSum = crLines.stream()
						.map(FactLine::getAmtAcctDr)
						.reduce(BigDecimal.ZERO, BigDecimal::add);
				if (drLineSum.signum() == 0)
				{
					crLines.add(zeroLines.get(0));
					zeroLines.clear();
				}
			}
		}

		this.drLines = ImmutableList.copyOf(drLines);
		this.crLines = ImmutableList.copyOf(crLines);
		this.zeroLines = ImmutableList.copyOf(zeroLines);

		type = extractType(this.drLines, this.crLines);
	}

	private static FactTrxLinesType extractType(
			@NonNull final List<FactLine> drLines,
			@NonNull final List<FactLine> crLines)
	{
		if (drLines.size() == 1 && crLines.size() >= 1)
		{
			return FactTrxLinesType.Debit;
		}
		//
		// Case: 1 credit line, one or more debit lines
		else if (drLines.size() >= 1 && crLines.size() == 1)
		{
			return FactTrxLinesType.Credit;
		}
		//
		// Case: no debit lines, no credit lines
		else if (drLines.isEmpty() && crLines.isEmpty())
		{
			return FactTrxLinesType.EmptyOrZero;
		}
		else
		{
			throw new AdempiereException("Invalid accounting operation structure (" + drLines.size() + " DR lines, " + crLines.size() + " CR lines)")
					.appendParametersToMessage()
					.setParameter("drLines", drLines)
					.setParameter("crLines", crLines);
		}
	}

	private void assertType(final FactTrxLinesType expected)
	{
		Check.assume(type == expected, "Invalid type. Expected {} but it was {}", expected, type);
	}

	public FactLine getDebitLine()
	{
		assertType(FactTrxLinesType.Debit);
		return drLines.get(0);
	}

	public FactLine getCreditLine()
	{
		assertType(FactTrxLinesType.Credit);
		return crLines.get(0);
	}

	public void forEachDebitLine(final Consumer<FactLine> debitLineConsumer)
	{
		drLines.forEach(debitLineConsumer);
	}

	public void forEachCreditLine(final Consumer<FactLine> creditLineConsumer)
	{
		crLines.forEach(creditLineConsumer);
	}

	public void forEachZeroLine(final Consumer<FactLine> zeroLineConsumer)
	{
		zeroLines.forEach(zeroLineConsumer);
	}
}
