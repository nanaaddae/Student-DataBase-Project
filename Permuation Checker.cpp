#include <iostream>
#include <string>
using namespace std;
#include<unordered_map>
int main()
{
	
	string str1,str2;
	
	cout<<"Enter in the first string\n";
	
	cin>>str1;
	

	unordered_map<char,int> mp1,mp2;

	cout<<"Enter in the second string\n";

	cin>>str2;
	
	

	for(int i = 0;i<str1.length();i++)
	{
		
		mp1[str1[i]++];
		
	}		
	
	
	
	for(int i = 0;i<str2.length();i++)
	{
		
		mp2[str2[i]++];
		
	}		
	
	
	if(mp1 == mp2)
	{
		cout<<"One string is a permutation of the other"<<endl;
	}
	
	else
		cout<<"The two string are not a permuation of one another!!!"<<endl;
	
	
	
	
	
	
	
	
	
	
	return 0;
	
	}
	
	
	
	
	
	
	

