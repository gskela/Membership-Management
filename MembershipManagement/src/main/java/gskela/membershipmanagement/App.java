/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gskela.membershipmanagement;

import java.util.LinkedList;

/**
 *
 * @author Aleks
 */
public class App {

    public static void main(String[] args) {
        String mem;

        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();

        LinkedList<Member> members = fh.readFile();
        int choice = mm.getChoice();

        while (choice != -1) {
            switch (choice) {
                case 1: {
                    mem = mm.addMembers(members);
                    fh.appendFile(mem);
                    break;
                }
                case 2: {
                    mm.removeMember(members);
                    fh.overwriteFile(members);
                    break;
                }
                case 3: {
                    mm.printMemberInfo(members);
                    break;
                }
                default: {
                    System.out.print("\nYou have selected an invalid option.\n");
                }
            }
            choice = mm.getChoice();
        }

        System.out.println("\nGood Bye");
    }
}
