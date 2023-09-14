package project_src;

import probability.domain.ArbitraryTokenDomain;
import probability.domain.BooleanDomain;
import probability.domain.FiniteIntegerDomain;
import probability.util.RandVar;

/**
 *	Muzaffer Tasiran - 181805017
 *	Sefa Samet Sutcu - 181805038
 */
public class ExampleRV {
	
	
	//projectRV
	public static final RandVar EXAM_LEVEL_RV = new RandVar("ExamLevel",
			new BooleanDomain());
	public static final RandVar IQ_LEVEL_RV = new RandVar("IqLevel",
			new BooleanDomain());
	public static final RandVar MARKS_RV = new RandVar("Marks",
			new BooleanDomain());
	public static final RandVar APTI_SCORE = new RandVar("Apti",
			new BooleanDomain());
	public static final RandVar ADMISSION_SCORE = new RandVar("Admission",
			new BooleanDomain());
	
	
}
