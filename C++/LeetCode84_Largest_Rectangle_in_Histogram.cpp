#include<vector>
#include<stack>
#include<climits>
using namespace std;
class Solution {
public:
    int maxArea;
    int largestRectangleArea(vector<int>& heights) {
        if(heights.size() == 0)
            return 0;
         maxArea = INT_MIN;
         stack<int> st;
         st.push(-1);
         for(int i = 0; i < heights.size(); i++){
             if(st.top() == -1 || heights[i] > heights[st.top()])
                 st.push(i);
             else{
                 int end = st.top();
                 while(st.top() != -1 && heights[st.top()] >= heights[i]){
                    getMaxArea(heights,st,end);
                 }
                 st.push(i);
             }
         }
        int end = heights.size() - 1;
        while(st.top() != -1){
            getMaxArea(heights,st,end);
        }
        return maxArea;
            
    }
    void getMaxArea(vector<int>& heights, stack<int>& st, int end){
        int index = st.top();
        st.pop();
        int begin = st.top();
        int length = heights[index];
        maxArea = max(maxArea, length * (end - begin));
    }
};