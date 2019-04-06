#include<unordered_map>
#include<vector>
#include<string>
using namespace std;
class Node{
public:
    string val;
    string root;
    double ratio;
    void set(string val, string root, double ratio){
        this->val = val;
        this->root = root;
        this->ratio = ratio;
    }
    string getRoot(){
        return this->root;
    }
};

class Solution {
public:
    unordered_map<string,Node> mymap;
    vector<double> calcEquation(vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries) {
        
        for(int i = 0; i < equations.size(); i++){
            string first = equations[i].first;
            string second = equations[i].second;
            double ratio = values[i];
            auto iter1 = mymap.find(first);
            auto iter2 = mymap.find(second);
            if(iter1 != mymap.end()){
                Node tmp;
                tmp.set(second, first, ratio);
                mymap[second] = tmp;
            }
            else if(iter2 != mymap.end()){
                Node tmp;
                tmp.set(first,second,1.0/ratio);
                mymap[first] = tmp;
            }
            else{
                Node tmp1;
                tmp1.set(first,first,1.0);
                mymap[first] = tmp1;
                Node tmp2;
                tmp2.set(second,first,ratio);
                mymap[second] = tmp2;
            }
        }
        vector<double> res;
        for(int i = 0; i < queries.size(); i++){
            res.push_back(getRatio(queries[i].first,queries[i].second));
        } 
        return res;
        
    }
    double getRatio(string a, string b){
        auto itera = mymap.find(a);
        auto iterb = mymap.find(b);
        if(itera == mymap.end() || iterb == mymap.end())
            return -1.0;
        string lasta = "";
        string cura = a;
        Node nodea;
        double ratioa = 1.0;
        while(cura != lasta){
            lasta = cura;
            nodea = mymap[cura];
            ratioa *= nodea.ratio;
            cura = nodea.root;
        }
        string lastb = "";
        string curb = b;
        Node nodeb;
        double ratiob = 1.0;
        while(curb != lastb){
            lastb = curb;
            nodeb = mymap[curb];
            ratiob *= nodeb.ratio;
            curb = nodeb.root;
        }
        if(lastb != lasta)
            return -1.0;
        return ratiob / ratioa;
    }
};