interface Crewmate
{
	public void doWork();
}

class ConcreteCrewmate implements Crewmate
{
	ConcreteCrewmate(){}

	@Override
	public void doWork(){
		System.out.println("doing work");
	}
}

class Imposter
{
	Imposter(){}
	public void doWork(){
		System.out.println("doing suspicious work");
	}
}

class ImposterAdapter implements Crewmate
{
	private Imposter im;
	
	ImposterAdapter(Imposter im){
		this.im = im;
	}

	@Override
	public void doWork(){
		System.out.println("doing work");
	}
}

class Main{
	public static void main(String[] args) {
		Crewmate crew = new ConcreteCrewmate();
		Imposter imp = new Imposter();

		crew.doWork();
		imp.doWork();

		ImposterAdapter imposterAdapter = new ImposterAdapter(imp);
		crew.doWork();
		imposterAdapter.doWork();
	}
}
