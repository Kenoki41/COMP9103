import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Class:   InsurancePolicy
// Purpose: To represent a particular customer's insurance agreement
public class InsurancePolicy {

    private Set<CoverType> mycoverage;
    private int claimCount = 0;
    // Each instance will have a unique policy number.
    private int policyNumber;

    private static int nextPolicy = 1;

    public InsurancePolicy()
    {
        this.policyNumber = nextPolicy;
        nextPolicy++;
        mycoverage = new HashSet<CoverType>();
    }

    // Determine this policy's number
    public int getPolicyNumber()
    {
        return policyNumber;
    }

    // Method:  getPolicyCost
    // Purpose: to report to the caller, the total cost of this policy, based on the covers
    //          that are selected
    public int getPolicyCost()
    {
        int cost = 0;
        for (CoverType t: mycoverage)
            cost += t.getPrice();
        return cost;
    }

    // Method:  includeCover
    // Purpose: To allow the caller to specify a type of insurance cover to be included for this policy.
    // Returns: True if the cover is now included; if it was already included or was unable to
    //          be included this time, false is returned.
    public boolean includeCover(CoverType which)
    {
        return mycoverage.add(which);
    }

    // Method:  lodgeAnotherClaim
    // Purpose: To increase the counter of how many claims have been made against this policy.
    // Parameter: lodgedType - specifies the type of cover being claimed. But only the types which
    //            have been included so far, will actually be countable.
    public void lodgeAnotherClaim(CoverType lodgedType)
    {
        if (includeCover(lodgedType) == true)
            claimCount++;
    }


    // Method:  toString
    // Purpose: Display a textual summary of this object's state
    @Override
    public String toString() {
        String type = null;
        for (CoverType t: mycoverage)
            type = t.getName();

        return "InsurancePolicy{ " +
                "mycoverage = " + type +
                " , policyNumber = " + getPolicyNumber() +
                " , claimCount = " + claimCount +
                " , policyCost = " + getPolicyCost() +
                '}';
    }
}