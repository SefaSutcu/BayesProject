package main;


import probability.FiniteProbabilityModel;
import probability.bayes.approx.BayesInferenceApproxAdapter;


import probability.bayes.approx.RejectionSampling;
import probability.bayes.exact.EliminationAsk;
import probability.bayes.exact.EnumerationAsk;
import probability.bayes.model.FiniteBayesModel;

import project_src.BayesNetExampleFactory;
import project_src.ExampleRV;



import probability.proposition.AssignmentProposition;




public class bayesmain {
	// Note: You should increase this to 1000000+
	// in order to get answers from the approximate
	// algorithms (i.e. Rejection, Likelihood and Gibbs)
	// that look close to their exact inference
	// counterparts.
	public static final int NUM_SAMPLES = 1000;

	public static void main(String[] args) {

		bayesEnumerationAskDemo();
		bayesEliminationAskDemo();
		bayesRejectionSamplingDemo();
		
	}


	public static void bayesEnumerationAskDemo() {		
		System.out.println("===========================");
		System.out.println("DEMO: Bayes Enumeration Ask");
		
		projectExampleModel(new FiniteBayesModel(
				BayesNetExampleFactory.constructProjectExample(),
				new EnumerationAsk()));
		
		System.out.println("==============================\n\n");
	}

	public static void bayesEliminationAskDemo() {
		System.out.println("===========================");
		System.out.println("DEMO: Bayes Elimination Ask");
		
		projectExampleModel(new FiniteBayesModel(
				BayesNetExampleFactory.constructProjectExample(),
				new EliminationAsk()));
		
		
		System.out.println("==============================\n\n");
	}

	public static void bayesRejectionSamplingDemo() {
		System.out.println("==============================");
		System.out.println("DEMO: Bayes Rejection Sampling N = " + NUM_SAMPLES);
		
		projectExampleModel(new FiniteBayesModel(
				BayesNetExampleFactory.constructProjectExample(),
				new BayesInferenceApproxAdapter(new RejectionSampling(),
						NUM_SAMPLES)));
		System.out.println("==============================\n\n");
	}

	
	
	private static void projectExampleModel(FiniteProbabilityModel model) {
		System.out.println("--------------------");
		System.out.println("Project Example Model\n");
		

		AssignmentProposition aexam = new AssignmentProposition(
				ExampleRV.EXAM_LEVEL_RV, Boolean.TRUE);
		AssignmentProposition anotexam = new AssignmentProposition(
				ExampleRV.EXAM_LEVEL_RV, Boolean.FALSE);
		AssignmentProposition aiq = new AssignmentProposition(
				ExampleRV.IQ_LEVEL_RV, Boolean.TRUE);
		AssignmentProposition anotiq = new AssignmentProposition(
				ExampleRV.IQ_LEVEL_RV, Boolean.FALSE);
		AssignmentProposition amarks = new AssignmentProposition(
				ExampleRV.MARKS_RV, Boolean.TRUE);
		AssignmentProposition anotmarks = new AssignmentProposition(
				ExampleRV.MARKS_RV, Boolean.FALSE);
		AssignmentProposition aadmission = new AssignmentProposition(
				ExampleRV.ADMISSION_SCORE, Boolean.TRUE);
		AssignmentProposition aaptiscore = new AssignmentProposition(
				ExampleRV.APTI_SCORE, Boolean.TRUE);
		AssignmentProposition anotaptiscore = new AssignmentProposition(
				ExampleRV.APTI_SCORE, Boolean.FALSE);

		System.out 
		.println("(for test)P<>(apti | iq = true) = "
				+ model.posteriorDistribution(ExampleRV.APTI_SCORE,
						aiq));
		
		System.out.println("P(admission,marks,apti,~exam,~iq) = "
				+ model.prior(aadmission, amarks, aaptiscore, anotexam,
						anotiq));

		
		System.out
				.println("P<>(Marks | Admission = true, Iq = false, Exam = false) = "
						+ model.posteriorDistribution(ExampleRV.MARKS_RV,
								aadmission, anotexam,
								anotiq));
		
		System.out
		.println("P<>(Admission | iq = true, exam=true) = "
				+ model.posteriorDistribution(ExampleRV.ADMISSION_SCORE,
						aiq, aexam));

		System.out
			.println("P<>(iq level | apti score = true, admission = true) = "
						+ model.posteriorDistribution(ExampleRV.IQ_LEVEL_RV,
								aaptiscore, aadmission));
		
	}
}
