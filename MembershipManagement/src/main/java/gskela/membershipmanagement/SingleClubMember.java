/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gskela.membershipmanagement;

/**
 *
 * @author Aleks
 */
public class SingleClubMember extends Member{
    
    private int club;
    
    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub){
        super(pMemberType, pMemberID, pName, pFees);
        club = pClub;
    }

    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }
    
    @Override
    public String toString(){
        return super.toString() + ", " + club;
    }
    
}
