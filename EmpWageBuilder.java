public class EmpWageBuilder
{
	public static final int IS_FULL_TIME= 2;
	public static final int IS_PART_TIME = 1;

	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHrsPerMonth;
	private int totalEmpWage;

	public EmpWageBuilder(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth)
	{
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsPerMonth = maxHrsPerMonth;
	}
	public void computeEmpWage()
	{
		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		while(totalEmpHrs<= maxHrsPerMonth && totalWorkingDays < numOfWorkingDays)
		{
			totalWorkingDays++;			
			int empCheck = (int) Math.floor(Math.random() * 10) % 3;
			switch(empCheck) {
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				case IS_PART_TIME:
					empHrs = 4;
					break;
				default:
					empHrs = 0;
			}
			
			totalEmpHrs += empHrs;
			System.out.println("Day#: "+ totalWorkingDays + "Emp Hr: "+empHrs);
		}
		totalEmpWage = totalEmpHrs * empRatePerHour;
		//System.out.println("Total Emp Wage for Company: "+company+" is: "+totalEmpWage);
		//return totalEmpWage;
	}
	@Override
	public String toString()
	{
		return "Total Emp Wage for Company "+company+" is: "+totalEmpWage;
	}
	public static void main(String[] args)
	{
		System.out.println("Welcome to Employee Wage Computation Problem");
		EmpWageBuilder dMart = new EmpWageBuilder("DMart", 20, 2, 10);
		EmpWageBuilder reliance = new EmpWageBuilder("Reliance", 10, 4, 20);
		dMart.computeEmpWage();
		System.out.println(dMart);
		reliance.computeEmpWage();
		System.out.println(reliance);
	}

		

}