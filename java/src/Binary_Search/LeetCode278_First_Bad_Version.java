package Binary_Search;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class LeetCode278_First_Bad_Version {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left) / 2; // or it will cause Integer over flow
            if(isBadVersion(mid))
                right = mid; //In order to converge to one number
            else
                left = mid + 1;
        }
        return right;
    }
}
