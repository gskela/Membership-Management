/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gskela.membershipmanagement;

/**
 *
 * @author Aleks
 */
public class MultiClubMember extends Member{
    
    private int membershipPoints;
    
    public MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoints){
        super(pMemberType, pMemberID, pName, pFees);
        membershipPoints = pMembershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }
    
        @Override
    public String toString(){
        return super.toString() + ", " + membershipPoints;
    }
    
}
