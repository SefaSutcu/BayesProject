package project_src;

import probability.bayes.BayesianNetwork;
import probability.bayes.FiniteNode;
import probability.bayes.impl.BayesNet;
import probability.bayes.impl.FullCPTNode;

/**
 *	Muzaffer Tasiran - 181805017
 *	Sefa Samet Sutcu - 181805038
 */
public class BayesNetExampleFactory {
	
	
	public static BayesianNetwork constructProjectExample() {
		FiniteNode examlevel = new FullCPTNode(ExampleRV.EXAM_LEVEL_RV,
				new double[] { 0.3, 0.7 });	
		FiniteNode iqlevel = new FullCPTNode(ExampleRV.IQ_LEVEL_RV,
				new double[] { 0.2, 0.8 });
		FiniteNode marks = new FullCPTNode(ExampleRV.MARKS_RV, new double[] {
				// exam=true, iq=true, marks=true
				0.2,
				// exam=true, iq=true, marks=false
				0.8,
				// exam=true, iq=false, marks=true
				0.1,
				//exam=true,iq=false, marks=false
				0.9,
				// exam=false, iq=true, marks=true
				0.5,
				//exam=false, iq=true, marks=false
				0.5,
				// exam=false, iq=false, marks=true
				0.4,
				// exam=false, iq=false, marks=false
				0.6 }, examlevel, iqlevel);
		@SuppressWarnings("unused")
		FiniteNode aptiscore = new FullCPTNode(ExampleRV.APTI_SCORE,
				new double[] {
						// iq=true, A=true
						0.6,
						// iq=true, A=false
						0.4,
						// iq=false, A=true
						0.25,
						// iq=false, A=false
						0.75 }, iqlevel);
		@SuppressWarnings("unused")
		FiniteNode admission = new FullCPTNode(ExampleRV.ADMISSION_SCORE,
				new double[] {
						// A=true, M=true
						0.1,
						// A=true, M=false
						0.9,
						// A=false, M=true
						0.4,
						// A=false, M=false
						0.6 }, marks);

		return new BayesNet(examlevel, iqlevel);
	}

	
	
}
