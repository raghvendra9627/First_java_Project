import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class InsurancePolicy {
    private static ArrayList<Policy> policyList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<String> list = new LinkedList<String>();

    public static void main(String[] args) {
        int choice = 0;
        int choice2 = 0;
        do{
        System.out.println("1. Sign Up");
        System.out.println("2. Sign In");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        choice2 = scanner.nextInt();
        switch (choice2){
            case 1:
                SignUp();
                SignUp2();
                break;
            case 2:
                System.out.println("Enter the Username: ");
                String usernameSignIn = scanner.next();
                System.out.println("Enter the password: ");
                String passwordSignIn = scanner.next();
                if(list.contains(passwordSignIn) && list.contains(usernameSignIn)){
                    System.out.println("welcome......");
                    do {
                        System.out.println("=========================================");
                        System.out.println("Insurance Policy Console Program");
                        System.out.println("=========================================");
                        System.out.println("1. Create Policy");
                        System.out.println("2. View Existing Policies");
                        System.out.println("3. Update Policy");
                        System.out.println("4. Exit");
                        System.out.print("Enter your choice: ");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                createPolicy();
                                break;
                            case 2:
                                viewPolicies();
                                break;
                            case 3:
                                updatePolicy();
                                break;
                            case 4:
                                System.out.println("Exiting program...");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    } while (choice != 4);
                }
                else{
                    System.out.println("either your username or password is Invalid");
                }
                break;
            case 3:
                System.out.println("Exiting program...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
            
            }
        }while(choice2 != 3);
                
    }


    private static void SignUp(){
        System.out.println("Enter the Username: ");
        String username = scanner.next();
        list.addFirst(username);
    }

    private static void SignUp2(){
        System.out.println("Enter the password: ");
        String password = scanner.next();
        list.addLast(password);
    }


    private static void createPolicy() {
        scanner.nextLine(); // Consume newline left-over by nextInt()
        System.out.println("=========================================");
        System.out.println("Create Policy");
        System.out.println("=========================================");
        System.out.print("Enter Policy Holder Name: ");
        String holderName = scanner.nextLine();
        System.out.print("Enter Policy Type (Auto/Home/Life): ");
        String type = scanner.nextLine();
        System.out.print("Enter Policy Start Date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();
        System.out.print("Enter Policy End Date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();
        System.out.print("Enter Premium Amount: ");
        double premium = scanner.nextDouble();
        System.out.print("Enter Coverage Amount: ");
        double coverage = scanner.nextDouble();
        Policy policy = new Policy(holderName, type, startDate, endDate, premium, coverage);
        policyList.add(policy);
        System.out.println("Policy created successfully!");
    }

    private static void viewPolicies() {
        System.out.println("=========================================");
        System.out.println("Existing Policies");
        System.out.println("=========================================");
        if (policyList.size() == 0) {
            System.out.println("No policies found.");
            return;
        }
//        for (Policy policy : policyList) {
        System.out.println(policyList);
//        }
    }

    private static void updatePolicy() {
        scanner.nextLine(); // Consume newline left-over by nextInt()
        System.out.println("=========================================");
        System.out.println("Update Policy");
        System.out.println("=========================================");
        System.out.print("Enter Policy Number to Update: ");
        int policyNumber = scanner.nextInt();
        Policy policy = getPolicy(policyNumber);
        if (policy == null) {
            System.out.println("Invalid policy number. Please try again.");
            return;
        }
        System.out.print("Enter Policy Holder Name (" + policy.getHolderName() + "): ");
        String holderName = scanner.nextLine();
        if (!holderName.isEmpty()) {
            policy.setHolderName(holderName);
        }
        System.out.print("Enter Policy Type (" + policy.getType() + "): ");
        String type = scanner.nextLine();
        if (!type.isEmpty()) {
            policy.setType(type);
        }
        System.out.print("Enter Policy Start Date (" + policy.getStartDate() + "): ");
        String startDate = scanner.nextLine();
        if (!startDate.isEmpty()) {
            policy.setStartDate(startDate);
        }
        System.out.print("Enter Policy End Date (" + policy.getEndDate() + "): ");
        String endDate = scanner.nextLine();
        if (!endDate.isEmpty()) {
            policy.setEndDate(endDate);
        }
        System.out.print("Enter Premium Amount (" + policy.getPremium() + "): ");
        String premiumString = scanner.nextLine();
        if (!premiumString.isEmpty()) {
            double premium = Double.parseDouble(premiumString);
            policy.setPremium(premium);
        }
        System.out.print("Enter Coverage Amount (" + policy.getCoverage() + "): ");
        String coverageString = scanner.nextLine();
        if (!coverageString.isEmpty()) {
            double coverage = Double.parseDouble(coverageString);
            policy.setCoverage(coverage);
        }
        System.out.println("Policy updated successfully!");
    }

    private static Policy getPolicy(int policyNumber) {
        for (Policy policy : policyList) {
            if (policy.getPolicyNumber() == policyNumber) {
                return policy;
            }
        }
        return null;
    }
}
class Policy {
    private static int nextPolicyNumber = 1;
    private int policyNumber;
    private String holderName;
    private String type;
    private String startDate;
    private String endDate;
    private double premium;
    private double coverage;

    public Policy(String holderName, String type, String startDate, String endDate, double premium, double coverage) {
        this.policyNumber = nextPolicyNumber++;
        this.holderName = holderName;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
        this.coverage = coverage;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public String toString() {
        return "Policy Number: " + policyNumber + "\n" +
                "Policy Holder: " + holderName + "\n" +
                "Policy Type: " + type + "\n" +
                "Start Date: " + startDate + "\n" +
                "End Date: " + endDate + "\n" +
                "Premium: " + premium + "\n" +
                "Coverage: " +coverage;

    }
}

