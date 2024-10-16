
package sardidostudents;

import java.util.Scanner;

public class SardidoStudents {

  public void addStudents(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Student First Name: ");
        String s_fname = sc.nextLine();
        System.out.println("Student Last Name: ");
        String s_lname = sc.nextLine();
        System.out.print("Student Age: ");
        String s_age = sc.nextLine();
        System.out.print("Student Email: ");
        String s_email = sc.nextLine();
        System.out.print("Student Address: ");
        String s_address = sc.nextLine();
        System.out.print("Student Phone Number: ");
        String s_phonenumber = sc.nextLine();
        
          String sql = "INSERT INTO students (s_fname, s_lname, s_age, s_email, s_address, s_phonenumber)VALUES (?, ?, ?, ?, ?, ?)";
          
          conf.addRecord(sql, s_fname, s_lname, s_age, s_email , s_address, s_phonenumber);
}
    private void viewStudents() {
        String query = "SELECT * FROM students";
        String[] headers = {"ID", "Student First Name", "Student Last Name", "Student Age", "Student Email", "Student Address", "Student Phone Number"};
        String[] columns = {"s_id", "s_fname", "s_lname", "s_age", "s_email", "s_address", "s_phonenumber"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
}
    public void updateStudents(){
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new Student First Name: ");
        String new_fname = sc.next();
        System.out.print("Enter new Student Last Name: ");
        String new_lname = sc.next();
        System.out.print("Enter new Student Age: ");
        String new_age = sc.next();
        System.out.print("Enter new Student Email: ");
        String new_email = sc.next();
        System.out.print("Enter new Student Address: ");
        String new_address = sc.next();
        System.out.print("Enter new Student Phone Number: ");
        String new_phonenumber = sc.next();
        
        String query = "UPDATE students SET s_fname = ?, s_lname = ?, s_age = ?, s_email = ?, s_address = ?, s_phonenumber = ? WHERE s_id = ?";
        
        config conf = new config();
        conf.updateRecord(query, new_fname, new_lname, new_age, new_email, new_address, new_phonenumber, id);
 }
    private void deleteStudent(){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM students WHERE s_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);

   }
    public static void main(String[] args) {
       
        SardidoStudents test = new SardidoStudents();
        Scanner sc = new Scanner(System.in);
        String response;
      
        do{  
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Action: ");
        int action = sc.nextInt();
        
        switch(action){
            case 1:
                test.addStudents();
            break;    
            case 2:
                test.viewStudents();
            break;
            case 3:
                test.viewStudents();
                test.updateStudents();
                break;
            case 4:
                test.viewStudents();
                test.deleteStudent();
                test.viewStudents();
            break;
                
        }
        System.out.print("Do you want to CONTINUE? ");
            response = sc.next();
            
        }while(response.equalsIgnoreCase("yes"));
            System.out.println("Thank You!");
    }
    
    
}
