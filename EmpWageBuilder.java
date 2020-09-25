import java.util.*;

public class EmpWageBuilder
{	
	public interface ComputeEmpWageInterface
	{
		public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth);
		public void computeEmpWage();
		public int computeEmpWage(CompanyEmpWage companyEmpWage);
		
	}
	public static class CompanyEmpWage
	{
		public String company;
		public int empRatePerHour;
		public int numOfWorkingDays;
		public int maxHrsPerMonth;
		public int totalEmpWage;
		public ArrayList<Integer> dailyWage = new ArrayList<Integer>();

		public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth)
		{
			this.company = company;
			this.empRatePerHour = empRatePerHour;
			this.numOfWorkingDays = numOfWorkingDays;
			this.maxHrsPerMonth = maxHrsPerMonth;
			
		}
		public void setTotalEmpWage(int totalEmpWage)
		{
			this.totalEmpWage = totalEmpWage;
		}
		@Override
		public String toString()
		{
			return "Total Emp Wage for Company "+company+" is: "+totalEmpWage;
		}

	}
	public static class EmpWageBuilderUC10 implements ComputeEmpWageInterface
	{
	
		static final int IS_FULL_TIME= 2;
		static final int IS_PART_TIME = 1;
	
		private int numOfCompany = 0;
		public ArrayList<CompanyEmpWage> companyEmpWageArraylist;
		public HashMap<String,CompanyEmpWage> companyEmpWageMap;
	
		public EmpWageBuilderUC10()
		{
			companyEmpWageArraylist =new ArrayList<CompanyEmpWage>();
			companyEmpWageMap = new HashMap<String,CompanyEmpWage>();
		}
		public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth)
		{
			CompanyEmpWage c = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays,maxHrsPerMonth);
			companyEmpWageArraylist.add(c);
			companyEmpWageMap.put(company,c);
			//numOfCompany++;
		}
		public void computeEmpWage()
		{
			for(int i=0; i<companyEmpWageArraylist.size(); i++)
			{
				CompanyEmpWage c = companyEmpWageArraylist.get(i);
				c.setTotalEmpWage(this.computeEmpWage(c));
				System.out.println(c);
			}
		}
		public int computeEmpWage(CompanyEmpWage companyEmpWage)
		{
			int empHrs = 0;
			int totalEmpHrs = 0;
			int totalWorkingDays = 0;
			while(totalEmpHrs<= companyEmpWage.maxHrsPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays)
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
				companyEmpWage.dailyWage.add( empHrs*companyEmpWage.empRatePerHour);
				System.out.println("Daily wage: "+ companyEmpWage.dailyWage.get(totalWorkingDays-1));
			}
			return totalEmpHrs * companyEmpWage.empRatePerHour;
			//System.out.println("Total Emp Wage for Company: "+company+" is: "+totalEmpWage);
			//return totalEmpWage;
		}
		public int getTotalWage(String company)
		{
			return companyEmpWageMap.get(company).totalEmpWage;
		}
	}	
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Employee Wage Computation Problem");
		EmpWageBuilderUC10 empWageBuilder = new EmpWageBuilderUC10();
		empWageBuilder.addCompanyEmpWage("DMart", 20, 2, 10);
		empWageBuilder.addCompanyEmpWage("Reliance", 10, 4, 20);
		empWageBuilder.computeEmpWage();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Company Name: ");
		String c = sc.nextLine();
		System.out.println("Total Emp wage of company "+ c +" is: "+ empWageBuilder.getTotalWage(c));
		
	}




}