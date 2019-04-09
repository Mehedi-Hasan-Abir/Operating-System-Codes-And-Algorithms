#include <iostream>
#include <string.h>
#include <vector>
#include <stdio.h>
#include <stdbool.h>

#define P 4
#define R 3

using namespace std;

int main()
{
	int allocated[P][R] = { { 0, 1, 0 },
							{ 2, 0, 0 },
							{ 3, 0, 2 },
							{ 2, 1, 1 } };

	int max[P][R] = { { 7, 5, 3 },
					{ 3, 2, 2 },
					{ 9, 0, 2 },
					{ 2, 2, 2 } };

	int resources[R] = { 10, 5, 7 };
	int available[R];

	for (int i = 0; i < R; i++) {

		int sum = 0;
		for (int j = 0; j < P; j++)
			sum += allocated[j][i];

		available[i] = resources[i] - sum;
	}

	vector<int> safe;
	int need[P][R];
	for (int i = 0; i < P; i++)
		for (int j = 0; j < R; j++)
			need[i][j] = max[i][j] - allocated[i][j];

	int running[4];
	memset(running,1, sizeof(running));
	int count = P ;
	int exec = 0;

	while(count != 0){
       for (int i = 0; i < P; i++) {
            if (running[i]) {
                exec = 1;
                for (int j = 0; j < R; j++) {
                    if (need[i][j] > available[j]) {
                        exec = 0;
                        break;
                    }
                }

                if (exec) {
                    printf("\nProcess%d is executing.\n", i + 1);
                    running[i] = 0;
                    count--;

                    for (int j = 0; j < R; j++)
                        available[j] += allocated[i][j];
                    //break;
                }
            }
        }
	}

	return 0;
}
