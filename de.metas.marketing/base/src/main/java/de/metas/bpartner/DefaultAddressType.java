package de.metas.bpartner;

import java.util.Map;
import java.util.stream.Stream;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.util.GuavaCollectors;

import lombok.Getter;
import lombok.NonNull;

/*
 * #%L
 * de.metas.adempiere.adempiere.base
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

public enum DefaultAddressType
{
	BillToDefault("B"), //
	ShipToDefault("S");

	@Getter
	private final String code;

	private DefaultAddressType(final String code)
	{
		this.code = code;
	}

	public static DefaultAddressType forCode(@NonNull final String code)
	{
		DefaultAddressType type = code2type.get(code);
		if (type == null)
		{
			throw new AdempiereException("No " + DefaultAddressType.class + " found for code: " + code);
		}
		return type;
	}

	private static final Map<String, DefaultAddressType> code2type = Stream.of(values())
			.collect(GuavaCollectors.toImmutableMapByKey(DefaultAddressType::getCode));

}
