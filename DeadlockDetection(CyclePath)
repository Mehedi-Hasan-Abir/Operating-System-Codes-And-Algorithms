#include<bits/stdc++.h>
#define sf(n) scanf("%d",&n)
#define SF(n) scanf("%lld",&n)
#define pb push_back
#define rep(i,n) for (int i=0;i<n;i++)
#define REP(i,n) for (int i=1;i<=n;i++)
#define pf(n) printf("%d\n",n)
#define PF(n) printf("%lld\n",n)
#define FAST ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define PII pair<int, int>


//*________________Declare priority queue vector with greater ___________*
//priority_queue<PII, vector<PII>, greater<PII> > Q;


/*------------------------------N Base Log---------------------------*/
//logb (x) = (loga(x)) / (loga(B))
//log base 2 (5) = (log base 10 (5) ) / (log base 10 (2) )

/*------------------------------Graph Moves----------------------------*/
//const int fx[]={+1,-1,+0,+0};
//const int fy[]={+0,+0,+1,-1};
//const int fx[]={+0,+0,+1,-1,-1,+1,-1,+1};   // Kings Move
//const int fy[]={-1,+1,+0,+0,+1,+1,-1,-1};  // Kings Move
//const int fx[]={-2, -2, -1, -1,  1,  1,  2,  2};  // Knights Move
//const int fy[]={-1,  1, -2,  2, -2,  2, -1,  1}; // Knights Move
/*---------------------------------------------------------------------*/

using namespace std;
typedef long long int ll;
vector<int> v[1037];
int visit[1948];
int par[1948];
bool f=false;
int cyclenumber=0;
int starting;
void dfs(int st)
{
    visit[st]=1;

    int l=v[st].size();
    for (int i=0;i<l;i++)
    {
        int u=v[st][i];
        if(visit[u]==0)
        {
            par[u]=st;
            dfs(u);
        }
        else if(visit[u]==1)
        {
            f=true;
            cout<<"Yes, cycle found and the cycle is"<<endl;
            int x=st;
            cout<<x<<" ";
            while(x!=u)
            {
                x=par[x];
                cout<<x<<" ";

            }
            cout<<st<<endl;
            }
    }
    visit[st]=2;
}


int main()
{
    printf("Enter number of total resources and process\n");
    int n;
    cin>>n;
    printf("Enter the number of connections\n");
    int e;
    cin>>e;
    printf("Mention the nodes that are connected from to to series\n");
    for (int i=0;i<e;i++)
    {
        int x,y;
        cin>>x>>y;
        v[x].pb(y);
    }
    int starting;
    printf("Enter the starting node\n");
    cin>>starting;
    dfs(starting);
    }




/*
3 3
1 2
2 3
3 1
*/
