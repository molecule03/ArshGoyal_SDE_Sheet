while(left <= k && right >= 0){
int sum = 0;
// System.out.println(" ");
// System.out.print(left+" "+right);
// System.out.println(" ");
for(int i=0; i<left; i++){
// System.out.print("left "+ num[i]+" ");
sum += num[i];
}
System.out.println(" ");
for(int i=n-1; i>=n-right; i--){
// System.out.print("right "+num[i]+" ");
sum += num[i];
}
maxScore = Math.max(sum, maxScore);
left++;
right--;
}