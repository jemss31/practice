
package taetae;

import java.util.Scanner;

public class TAETAE {
    config con = new config();
    Scanner sc = new Scanner(System.in);
    
    public void add(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Student First Name: ");
        String fname = sc.next();
        System.out.print("Student Last Name: ");
        String lname = sc.next();
        System.out.print("Student Email: ");
        String email = sc.next();
        System.out.print("Student Status: ");
        String status = sc.next();

        String sql = "INSERT INTO tbl_students (s_name, s_lname, s_email, s_status) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, fname, lname, email, status);
    } 
    
  private void view() {
        String Query = "SELECT * FROM tbl_students";
        String[] Headers = {"ID", "First Name", "Last Name", "Email", "Status"};
        String[] Columns = {"s_id", "s_name", "s_lname", "s_email", "s_status"};

        con.viewRecords(Query, Headers, Columns);
    }
   private void update(){
       System.out.println("Enter ID to edit: ");
       int id = sc.nextInt();
       System.out.println("Enter new name: ");
       String name = sc.next();
       System.out.println("Enter new last name: ");
       String lnane = sc.next();
       System.out.println("Email: ");
       String email = sc.next();
       System.out.println("Status: ");
       String status = sc.next();
       

        String sqlUpdate = "UPDATE tbl_students SET s_name = ?, s_lname = ?, s_email = ?, s_status = ?  WHERE s_id = ?";
        con.updateRecord(sqlUpdate, name, lnane, email, status, id);
    
    }
   private void delete(){
       System.out.println("Enter ID to delete: ");
       int id = sc.nextInt();
        String sqlDelete = "DELETE FROM tbl_students WHERE s_id = ?";
        con.deleteRecord(sqlDelete, id);
   
   }
   
           
           
    public void menu(){
        int choice;
    do {    
     System.out.println("\nChoose an option:");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    view();
                    update();
                    break;
                case 4:
                    view();
                    delete();
                    break;
                case 5:
                    System.out.println("Thank you");
                    break;
            }
          }while (choice !=5);

    }
}
