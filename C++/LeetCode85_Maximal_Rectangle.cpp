#include<vector>
#include<stack>
using namespace std;
class Solution {
public:
    int maxArea = 0;
    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.size() == 0 || matrix[0].size() == 0)
            return 0;
        vector<vector<int>> v;
        for(int i = 0; i < matrix.size(); i++){
            vector<int> tmp;
            for(int j = 0; j < matrix[0].size(); j++){
                int res = 0;
                for(int k = i; k >= 0; k--){
                    if(matrix[k][j] == '1')
                        res++;
                    else
                        break;
                }
                tmp.push_back(res);
            }
            v.push_back(tmp);
        }
        // for(int i = 0; i < v[2].size(); i++)
        //     cout<<v[2][i]<<endl;
        for(int i = 0; i < v.size(); i++)
            largestRectangleArea(v[i]);
        return maxArea;
    }
    void largestRectangleArea(vector<int>& heights) {
        if(heights.size() == 0)
            return ;
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
    }
    void getMaxArea(vector<int>& heights, stack<int>& st, int end){
        int index = st.top();
        st.pop();
        int begin = st.top();
        int length = heights[index];
        maxArea = max(maxArea, length * (end - begin));
    }
};