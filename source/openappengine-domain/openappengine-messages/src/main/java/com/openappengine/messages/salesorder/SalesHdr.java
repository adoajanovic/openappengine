package com.openappengine.messages.salesorder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

public class SalesHdr {

    protected BigInteger salesId;
    protected String ordType;
    protected BigInteger partyId;
    protected String status;
    protected BigDecimal totQty;
    protected BigDecimal totAmt;
    protected BigDecimal totTax;
    protected BigDecimal totWeight;
    protected String curCode;
    protected XMLGregorianCalendar ordDate;
    protected XMLGregorianCalendar canDate;
    protected String modePay;
    protected String shipType;
    protected String carrier;
    protected BigDecimal shipCharg;
    protected String user;
    protected List<SalesDet> salesDet;

    /**
     * Gets the value of the salesId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSalesId() {
        return salesId;
    }

    /**
     * Sets the value of the salesId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSalesId(BigInteger value) {
        this.salesId = value;
    }

    /**
     * Gets the value of the ordType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdType() {
        return ordType;
    }

    /**
     * Sets the value of the ordType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdType(String value) {
        this.ordType = value;
    }

    /**
     * Gets the value of the partyId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPartyId() {
        return partyId;
    }

    /**
     * Sets the value of the partyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPartyId(BigInteger value) {
        this.partyId = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the totQty property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotQty() {
        return totQty;
    }

    /**
     * Sets the value of the totQty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotQty(BigDecimal value) {
        this.totQty = value;
    }

    /**
     * Gets the value of the totAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotAmt() {
        return totAmt;
    }

    /**
     * Sets the value of the totAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotAmt(BigDecimal value) {
        this.totAmt = value;
    }

    /**
     * Gets the value of the totTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotTax() {
        return totTax;
    }

    /**
     * Sets the value of the totTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotTax(BigDecimal value) {
        this.totTax = value;
    }

    /**
     * Gets the value of the totWeight property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotWeight() {
        return totWeight;
    }

    /**
     * Sets the value of the totWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotWeight(BigDecimal value) {
        this.totWeight = value;
    }

    /**
     * Gets the value of the curCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurCode() {
        return curCode;
    }

    /**
     * Sets the value of the curCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurCode(String value) {
        this.curCode = value;
    }

    /**
     * Gets the value of the ordDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrdDate() {
        return ordDate;
    }

    /**
     * Sets the value of the ordDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrdDate(XMLGregorianCalendar value) {
        this.ordDate = value;
    }

    /**
     * Gets the value of the canDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCanDate() {
        return canDate;
    }

    /**
     * Sets the value of the canDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCanDate(XMLGregorianCalendar value) {
        this.canDate = value;
    }

    /**
     * Gets the value of the modePay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModePay() {
        return modePay;
    }

    /**
     * Sets the value of the modePay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModePay(String value) {
        this.modePay = value;
    }

    /**
     * Gets the value of the shipType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipType() {
        return shipType;
    }

    /**
     * Sets the value of the shipType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipType(String value) {
        this.shipType = value;
    }

    /**
     * Gets the value of the carrier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * Sets the value of the carrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrier(String value) {
        this.carrier = value;
    }

    /**
     * Gets the value of the shipCharg property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShipCharg() {
        return shipCharg;
    }

    /**
     * Sets the value of the shipCharg property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShipCharg(BigDecimal value) {
        this.shipCharg = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Gets the value of the salesDet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salesDet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalesDet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SalesDet }
     * 
     * 
     */
    public List<SalesDet> getSalesDet() {
        if (salesDet == null) {
            salesDet = new ArrayList<SalesDet>();
        }
        return this.salesDet;
    }

}
