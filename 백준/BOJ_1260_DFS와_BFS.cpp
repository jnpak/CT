//백준 1260

#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

#define MAX 1001

int map[MAX][MAX];
int visited[MAX];
queue<int> q;
int N, M, V;

void DFS(int v) {
	cout << v << " ";
	visited[v] = 1;
	for (int i = 1; i <= N; i++) {
		if (map[v][i] && !visited[i]){
			DFS(i);
		}
	}
}

void BFS(int v) {
	visited[v] = 1;
	q.push(v);

	while (!q.empty()) {
		v = q.front();
		q.pop();

		cout << v << " ";
		for (int i = 1; i <= N; i++) {
			if (map[v][i] && !visited[i]) {
				q.push(i);
				visited[i] = 1;
			}
		}
	}
}

int main() {

	cin >>  N >> M >> V;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		map[a][b] = 1;
		map[b][a] = 1;
	}

	DFS(V);
	cout << "\n";
	memset(visited, 0, sizeof(visited));
	BFS(V);
	return 0;
}

// #include <cstring> 헤더
// void* memset(void* ptr, int value, size_t num);
// ptr - 메모리 시작주소 ex)배열이름
// value - 채우고자하는 값
// num - 메모리 크기 ex) sizeof(array)