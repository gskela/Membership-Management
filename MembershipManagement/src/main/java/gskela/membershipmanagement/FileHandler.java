/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gskela.membershipmanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Aleks
 */
public class FileHandler {

    public LinkedList<Member> readFile() {
        LinkedList<Member> memberList = new LinkedList();
        String lineRead;
        String[] splitLine;
        Member member;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(", ");
                if (splitLine[0].equals("S")) {
                    member = new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                } else {
                    member = new MultiClubMember('M', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                }
                memberList.add(member);
                lineRead = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return memberList;
    }

    public void appendFile(String mem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
            writer.write(mem + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void overwriteFile(LinkedList<Member> memberList) {
        String memAsString;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {
            for (int i = 0; i < memberList.size(); i++) {
                memAsString = memberList.get(i).toString();
                writer.write(memAsString + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            File permanentFile = new File("members.csv");
            File tempFile = new File("members.temp");
            permanentFile.delete();
            tempFile.renameTo(permanentFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
