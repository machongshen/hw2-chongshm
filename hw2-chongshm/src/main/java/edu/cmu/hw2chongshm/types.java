

/* First created by JCasGen Sat Oct 04 16:18:54 EDT 2014 */
package edu.cmu.hw2chongshm;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Oct 07 14:18:12 EDT 2014
 * XML source: /Users/machongshen/git/hw2-chongshm/hw2-chongshm/src/main/resources/descriptors/Type_System_hw1.xml
 * @generated */
public class types extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(types.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected types() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public types(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public types(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public types(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: Gene_Sign

  /** getter for Gene_Sign - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGene_Sign() {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_Gene_Sign == null)
      jcasType.jcas.throwFeatMissing("Gene_Sign", "edu.cmu.hw2chongshm.types");
    return jcasType.ll_cas.ll_getStringValue(addr, ((types_Type)jcasType).casFeatCode_Gene_Sign);}
    
  /** setter for Gene_Sign - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGene_Sign(String v) {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_Gene_Sign == null)
      jcasType.jcas.throwFeatMissing("Gene_Sign", "edu.cmu.hw2chongshm.types");
    jcasType.ll_cas.ll_setStringValue(addr, ((types_Type)jcasType).casFeatCode_Gene_Sign, v);}    
   
    
  //*--------------*
  //* Feature: Gene_Mark

  /** getter for Gene_Mark - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGene_Mark() {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_Gene_Mark == null)
      jcasType.jcas.throwFeatMissing("Gene_Mark", "edu.cmu.hw2chongshm.types");
    return jcasType.ll_cas.ll_getStringValue(addr, ((types_Type)jcasType).casFeatCode_Gene_Mark);}
    
  /** setter for Gene_Mark - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGene_Mark(String v) {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_Gene_Mark == null)
      jcasType.jcas.throwFeatMissing("Gene_Mark", "edu.cmu.hw2chongshm.types");
    jcasType.ll_cas.ll_setStringValue(addr, ((types_Type)jcasType).casFeatCode_Gene_Mark, v);}    
   
    
  //*--------------*
  //* Feature: start

  /** getter for start - gets 
   * @generated
   * @return value of the feature 
   */
  public int getStart() {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_start == null)
      jcasType.jcas.throwFeatMissing("start", "edu.cmu.hw2chongshm.types");
    return jcasType.ll_cas.ll_getIntValue(addr, ((types_Type)jcasType).casFeatCode_start);}
    
  /** setter for start - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setStart(int v) {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_start == null)
      jcasType.jcas.throwFeatMissing("start", "edu.cmu.hw2chongshm.types");
    jcasType.ll_cas.ll_setIntValue(addr, ((types_Type)jcasType).casFeatCode_start, v);}    
   
    
  //*--------------*
  //* Feature: end

  /** getter for end - gets 
   * @generated
   * @return value of the feature 
   */
  public int getEnd() {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_end == null)
      jcasType.jcas.throwFeatMissing("end", "edu.cmu.hw2chongshm.types");
    return jcasType.ll_cas.ll_getIntValue(addr, ((types_Type)jcasType).casFeatCode_end);}
    
  /** setter for end - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setEnd(int v) {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_end == null)
      jcasType.jcas.throwFeatMissing("end", "edu.cmu.hw2chongshm.types");
    jcasType.ll_cas.ll_setIntValue(addr, ((types_Type)jcasType).casFeatCode_end, v);}    
   
    
  //*--------------*
  //* Feature: confidence

  /** getter for confidence - gets 
   * @generated
   * @return value of the feature 
   */
  public double getConfidence() {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "edu.cmu.hw2chongshm.types");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((types_Type)jcasType).casFeatCode_confidence);}
    
  /** setter for confidence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setConfidence(double v) {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "edu.cmu.hw2chongshm.types");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((types_Type)jcasType).casFeatCode_confidence, v);}    
   
    
  //*--------------*
  //* Feature: casProcessorId

  /** getter for casProcessorId - gets 
   * @generated
   * @return value of the feature 
   */
  public String getCasProcessorId() {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_casProcessorId == null)
      jcasType.jcas.throwFeatMissing("casProcessorId", "edu.cmu.hw2chongshm.types");
    return jcasType.ll_cas.ll_getStringValue(addr, ((types_Type)jcasType).casFeatCode_casProcessorId);}
    
  /** setter for casProcessorId - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCasProcessorId(String v) {
    if (types_Type.featOkTst && ((types_Type)jcasType).casFeat_casProcessorId == null)
      jcasType.jcas.throwFeatMissing("casProcessorId", "edu.cmu.hw2chongshm.types");
    jcasType.ll_cas.ll_setStringValue(addr, ((types_Type)jcasType).casFeatCode_casProcessorId, v);}    
  }

    