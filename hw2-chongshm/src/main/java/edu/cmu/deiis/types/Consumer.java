

/* First created by JCasGen Tue Oct 07 15:29:24 EDT 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Oct 08 00:52:40 EDT 2014
 * XML source: /Users/machongshen/git/hw2-chongshm/hw2-chongshm/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Consumer extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Consumer.class);
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
  protected Consumer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Consumer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Consumer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Consumer(JCas jcas, int begin, int end) {
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
    if (Consumer_Type.featOkTst && ((Consumer_Type)jcasType).casFeat_Gene_Sign == null)
      jcasType.jcas.throwFeatMissing("Gene_Sign", "edu.cmu.deiis.types.Consumer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Consumer_Type)jcasType).casFeatCode_Gene_Sign);}
    
  /** setter for Gene_Sign - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGene_Sign(String v) {
    if (Consumer_Type.featOkTst && ((Consumer_Type)jcasType).casFeat_Gene_Sign == null)
      jcasType.jcas.throwFeatMissing("Gene_Sign", "edu.cmu.deiis.types.Consumer");
    jcasType.ll_cas.ll_setStringValue(addr, ((Consumer_Type)jcasType).casFeatCode_Gene_Sign, v);}    
   
    
  //*--------------*
  //* Feature: Gene_Mark

  /** getter for Gene_Mark - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGene_Mark() {
    if (Consumer_Type.featOkTst && ((Consumer_Type)jcasType).casFeat_Gene_Mark == null)
      jcasType.jcas.throwFeatMissing("Gene_Mark", "edu.cmu.deiis.types.Consumer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Consumer_Type)jcasType).casFeatCode_Gene_Mark);}
    
  /** setter for Gene_Mark - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGene_Mark(String v) {
    if (Consumer_Type.featOkTst && ((Consumer_Type)jcasType).casFeat_Gene_Mark == null)
      jcasType.jcas.throwFeatMissing("Gene_Mark", "edu.cmu.deiis.types.Consumer");
    jcasType.ll_cas.ll_setStringValue(addr, ((Consumer_Type)jcasType).casFeatCode_Gene_Mark, v);}    
   
    
  //*--------------*
  //* Feature: start

  /** getter for start - gets 
   * @generated
   * @return value of the feature 
   */
  public int getStart() {
    if (Consumer_Type.featOkTst && ((Consumer_Type)jcasType).casFeat_start == null)
      jcasType.jcas.throwFeatMissing("start", "edu.cmu.deiis.types.Consumer");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Consumer_Type)jcasType).casFeatCode_start);}
    
  /** setter for start - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setStart(int v) {
    if (Consumer_Type.featOkTst && ((Consumer_Type)jcasType).casFeat_start == null)
      jcasType.jcas.throwFeatMissing("start", "edu.cmu.deiis.types.Consumer");
    jcasType.ll_cas.ll_setIntValue(addr, ((Consumer_Type)jcasType).casFeatCode_start, v);}    
   
    
  //*--------------*
  //* Feature: end

  /** getter for end - gets 
   * @generated
   * @return value of the feature 
   */
  public int getEnd() {
    if (Consumer_Type.featOkTst && ((Consumer_Type)jcasType).casFeat_end == null)
      jcasType.jcas.throwFeatMissing("end", "edu.cmu.deiis.types.Consumer");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Consumer_Type)jcasType).casFeatCode_end);}
    
  /** setter for end - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setEnd(int v) {
    if (Consumer_Type.featOkTst && ((Consumer_Type)jcasType).casFeat_end == null)
      jcasType.jcas.throwFeatMissing("end", "edu.cmu.deiis.types.Consumer");
    jcasType.ll_cas.ll_setIntValue(addr, ((Consumer_Type)jcasType).casFeatCode_end, v);}    
  }

    