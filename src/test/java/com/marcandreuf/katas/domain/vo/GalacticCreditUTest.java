package com.marcandreuf.katas.domain.vo;

/**
 * Created by marc on 21/04/17.
 */
public class GalacticCreditUTest {

    //Todo: Change the design.
    // The Expressions do not need to know about VOs if the expressions can use an IGalacticCalculator.
    // The expression Calculate(IGalacticCalculator) method are responsible to know what method of the
    // IGalacticCalculator they need to call to perform the calculation.
    // IGalacticCalculator.galacticCreditValue(givenValue, galacticNumbers...) return the value of the Credit.


    //TODO: GalacticCredit does not need list of galacticNumbers.







    public void shouldCreateAGalacticCredit(){

        GalacticCredit galacticCredit = GalacticCreditBuilder.symbol("Silver").arabicValue(100.1);



    }
}
