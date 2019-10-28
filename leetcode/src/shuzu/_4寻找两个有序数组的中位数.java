package shuzu;

public class _4寻找两个有序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if (m>n){
            int[] tmp=nums1;nums1=nums2;nums2=tmp;
            m=n;
            n=nums2.length;
        }
        int mBegin=0,mEnd=m,mMid,nMid;
        while (mBegin<=mEnd){
            mMid=(mEnd+mBegin)/2;
            nMid=(m+n+1)/2-mMid;
            if (mMid<mEnd&&nums1[mMid]<nums2[nMid-1]){
                mBegin=mMid+1;
            }else if (mMid>mBegin&&nums1[mMid-1]>nums2[nMid]){
                mEnd=mMid-1;
            }else {
                int maxLeft=0;
                if (mMid==0) maxLeft=nums2[nMid-1];
                else if (nMid==0) maxLeft=nums1[mMid-1];
                else maxLeft=Math.max(nums2[nMid-1],nums1[mMid-1]);
                if ((m+n)%2==1) return maxLeft;

                int minRight=0;
                if (mMid==m) minRight=nums2[nMid];
                else if (nMid==n) minRight=nums1[mMid];
                else minRight=Math.min(nums2[nMid],nums1[mMid]);
                return (maxLeft+minRight)/2.0;
            }
        }

        return 0;
    }

    private double myMethod(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if (m>n){
            int[] tmp=nums1;nums1=nums2;nums2=tmp;
        }
        m=nums1.length;
        int mBegin=0,mEnd=m-1,mMid=m/2;
        n=nums2.length;
        int nBegin=0,nEnd=n-1,nMid=n/2;
        ;
        int l=m+n;

        if (m==0||nums1[mEnd]<=nums2[(l/2-1)-mEnd]){
            if (l%2==0){
                if (m==n){
                    return (nums1[mEnd]+nums2[nBegin])/2.0;
                }
                return (nums2[(l/2-1)-mEnd]+nums2[(l/2-1)-mEnd-1])/2.0;
            }else {
                return nums2[(l/2-1)-mEnd];
            }
        }else if (nums1[mBegin]>=nums2[(l/2-1)]){
            if (l%2==0){
                if (m==n){
                    return (nums1[mBegin]+nums2[nEnd])/2.0;
                }
                return (nums2[(l/2-1)]+nums2[(l/2-1)-1])/2.0;
            }else {
                return Math.max(nums1[mEnd],nums2[l/2-1]);
            }
        } else {
            while((mMid+nMid)!=(l/2-1)){
                if ((mMid+nMid)>(l/2-1)){
                    if (nums1[mMid]<=nums2[nMid]){
                        nEnd=nMid-1;
                        nMid=(nBegin+nEnd)/2;
                    }else {
                        mEnd=mMid-1;
                        mMid=(mBegin+mEnd)/2;
                    }
                }else {
                    if (nums1[mMid]>=nums2[nMid]){
                        nBegin=nMid+1;
                        nMid=(nBegin+nEnd)/2;
                    }else {
                        mBegin=mMid+1;
                        mMid=(mBegin+mEnd)/2;
                    }
                }
            }
        }
        System.out.println(mMid);
        System.out.println(nMid);
        if (l%2==0){
            return (nums1[mMid]+nums2[nMid])/2.0;
        }else {
            return Math.max(nums1[mMid], nums2[nMid]);
        }
    }

    public static void main(String[] args) {
        int[] m={-2,-1};
        int[] n={3};
        double medianSortedArrays = new _4寻找两个有序数组的中位数().findMedianSortedArrays(m, n);
        System.out.println(medianSortedArrays);
    }
}
