/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package de.metas.flatrate.model;

import java.sql.ResultSet;
import java.util.Properties;

/** Generated Model for C_Invoice_Clearing_Alloc
 *  @author Adempiere (generated) 
 */
@SuppressWarnings("javadoc")
public class X_C_Invoice_Clearing_Alloc extends org.compiere.model.PO implements I_C_Invoice_Clearing_Alloc, org.compiere.model.I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = -2048207167L;

    /** Standard Constructor */
    public X_C_Invoice_Clearing_Alloc (Properties ctx, int C_Invoice_Clearing_Alloc_ID, String trxName)
    {
      super (ctx, C_Invoice_Clearing_Alloc_ID, trxName);
      /** if (C_Invoice_Clearing_Alloc_ID == 0)
        {
			setC_Flatrate_Term_ID (0);
			setC_Invoice_Cand_ToClear_ID (0);
			setC_Invoice_Clearing_Alloc_ID (0);
        } */
    }

    /** Load Constructor */
    public X_C_Invoice_Clearing_Alloc (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }


    /** Load Meta Data */
    @Override
    protected org.compiere.model.POInfo initPO (Properties ctx)
    {
      org.compiere.model.POInfo poi = org.compiere.model.POInfo.getPOInfo (ctx, Table_Name, get_TrxName());
      return poi;
    }

	@Override
	public de.metas.flatrate.model.I_C_Flatrate_DataEntry getC_Flatrate_DataEntry() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_C_Flatrate_DataEntry_ID, de.metas.flatrate.model.I_C_Flatrate_DataEntry.class);
	}

	@Override
	public void setC_Flatrate_DataEntry(de.metas.flatrate.model.I_C_Flatrate_DataEntry C_Flatrate_DataEntry)
	{
		set_ValueFromPO(COLUMNNAME_C_Flatrate_DataEntry_ID, de.metas.flatrate.model.I_C_Flatrate_DataEntry.class, C_Flatrate_DataEntry);
	}

	/** Set Abrechnungssatz.
		@param C_Flatrate_DataEntry_ID Abrechnungssatz	  */
	@Override
	public void setC_Flatrate_DataEntry_ID (int C_Flatrate_DataEntry_ID)
	{
		if (C_Flatrate_DataEntry_ID < 1) 
			set_Value (COLUMNNAME_C_Flatrate_DataEntry_ID, null);
		else 
			set_Value (COLUMNNAME_C_Flatrate_DataEntry_ID, Integer.valueOf(C_Flatrate_DataEntry_ID));
	}

	/** Get Abrechnungssatz.
		@return Abrechnungssatz	  */
	@Override
	public int getC_Flatrate_DataEntry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Flatrate_DataEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public de.metas.flatrate.model.I_C_Flatrate_Term getC_Flatrate_Term() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_C_Flatrate_Term_ID, de.metas.flatrate.model.I_C_Flatrate_Term.class);
	}

	@Override
	public void setC_Flatrate_Term(de.metas.flatrate.model.I_C_Flatrate_Term C_Flatrate_Term)
	{
		set_ValueFromPO(COLUMNNAME_C_Flatrate_Term_ID, de.metas.flatrate.model.I_C_Flatrate_Term.class, C_Flatrate_Term);
	}

	/** Set Pauschale - Vertragsperiode.
		@param C_Flatrate_Term_ID Pauschale - Vertragsperiode	  */
	@Override
	public void setC_Flatrate_Term_ID (int C_Flatrate_Term_ID)
	{
		if (C_Flatrate_Term_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Flatrate_Term_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Flatrate_Term_ID, Integer.valueOf(C_Flatrate_Term_ID));
	}

	/** Get Pauschale - Vertragsperiode.
		@return Pauschale - Vertragsperiode	  */
	@Override
	public int getC_Flatrate_Term_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Flatrate_Term_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public de.metas.invoicecandidate.model.I_C_Invoice_Candidate getC_Invoice_Cand_ToClear() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_C_Invoice_Cand_ToClear_ID, de.metas.invoicecandidate.model.I_C_Invoice_Candidate.class);
	}

	@Override
	public void setC_Invoice_Cand_ToClear(de.metas.invoicecandidate.model.I_C_Invoice_Candidate C_Invoice_Cand_ToClear)
	{
		set_ValueFromPO(COLUMNNAME_C_Invoice_Cand_ToClear_ID, de.metas.invoicecandidate.model.I_C_Invoice_Candidate.class, C_Invoice_Cand_ToClear);
	}

	/** Set Zu verrechnender Rechn-Kand..
		@param C_Invoice_Cand_ToClear_ID Zu verrechnender Rechn-Kand.	  */
	@Override
	public void setC_Invoice_Cand_ToClear_ID (int C_Invoice_Cand_ToClear_ID)
	{
		if (C_Invoice_Cand_ToClear_ID < 1) 
			set_Value (COLUMNNAME_C_Invoice_Cand_ToClear_ID, null);
		else 
			set_Value (COLUMNNAME_C_Invoice_Cand_ToClear_ID, Integer.valueOf(C_Invoice_Cand_ToClear_ID));
	}

	/** Get Zu verrechnender Rechn-Kand..
		@return Zu verrechnender Rechn-Kand.	  */
	@Override
	public int getC_Invoice_Cand_ToClear_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_Cand_ToClear_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public de.metas.invoicecandidate.model.I_C_Invoice_Candidate getC_Invoice_Candidate() throws RuntimeException
	{
		return get_ValueAsPO(COLUMNNAME_C_Invoice_Candidate_ID, de.metas.invoicecandidate.model.I_C_Invoice_Candidate.class);
	}

	@Override
	public void setC_Invoice_Candidate(de.metas.invoicecandidate.model.I_C_Invoice_Candidate C_Invoice_Candidate)
	{
		set_ValueFromPO(COLUMNNAME_C_Invoice_Candidate_ID, de.metas.invoicecandidate.model.I_C_Invoice_Candidate.class, C_Invoice_Candidate);
	}

	/** Set Rechnungskandidat.
		@param C_Invoice_Candidate_ID 
		Eindeutige Identifikationsnummer eines Rechnungskandidaten
	  */
	@Override
	public void setC_Invoice_Candidate_ID (int C_Invoice_Candidate_ID)
	{
		if (C_Invoice_Candidate_ID < 1) 
			set_Value (COLUMNNAME_C_Invoice_Candidate_ID, null);
		else 
			set_Value (COLUMNNAME_C_Invoice_Candidate_ID, Integer.valueOf(C_Invoice_Candidate_ID));
	}

	/** Get Rechnungskandidat.
		@return Eindeutige Identifikationsnummer eines Rechnungskandidaten
	  */
	@Override
	public int getC_Invoice_Candidate_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_Candidate_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Rechnungskanditad - Verrechnung.
		@param C_Invoice_Clearing_Alloc_ID Rechnungskanditad - Verrechnung	  */
	@Override
	public void setC_Invoice_Clearing_Alloc_ID (int C_Invoice_Clearing_Alloc_ID)
	{
		if (C_Invoice_Clearing_Alloc_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_Clearing_Alloc_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_Clearing_Alloc_ID, Integer.valueOf(C_Invoice_Clearing_Alloc_ID));
	}

	/** Get Rechnungskanditad - Verrechnung.
		@return Rechnungskanditad - Verrechnung	  */
	@Override
	public int getC_Invoice_Clearing_Alloc_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_Clearing_Alloc_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}