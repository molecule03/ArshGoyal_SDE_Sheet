/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> spiralMatrix(int m, int n, ListNode* head) {
        
        // int mat[][] = new int[m][n];
        vector<vector<int>> mat(m, vector<int>(n, -1));
        
        ListNode* cur = head;
        int colB = 0;
        int colE = n-1;
        int rowB = 0;
        int rowE = m-1;
        
        while(colB <= colE && rowB <= rowE){
            
            for(int i=colB; i<=colE; i++){
                if(cur == NULL){
                    mat[rowB][i] = -1;
                }else{
                    mat[rowB][i] = cur->val;
                    cur = cur->next;
                }
            }
            rowB++;
            
            
            for(int i=rowB; i<=rowE; i++){
                if(cur == NULL){
                    mat[i][colE] = -1;
                }else{
                    mat[i][colE] = cur->val;
                    cur = cur->next;
                }
            }
            colE--;
            
            if(rowB <= rowE){
            for(int i=colE; i>=colB; i--){
                if(cur == NULL){
                    mat[rowE][i] = -1;
                }else{
                    mat[rowE][i] = cur->val;
                    cur = cur->next;
                }
            }}
            rowE--;
            
            
            if(colB <= colE){
            for(int i=rowE; i>=rowB; i--){
                if(cur == NULL){
                    mat[i][colB] = -1;
                }else{
                    mat[i][colB] = cur->val;
                    cur = cur->next;
                }
            }}
            colB++;
            
            
        }
        
        return mat;
    }
};