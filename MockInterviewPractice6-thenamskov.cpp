#include <iostream>
#include <chrono>
#include  <queue>

std::queue<long long> get_prime_numbers(long long boundary) {
    std::queue<long long> prime_numbers;
    int counter = 0;
    boundary+=1;
    bool ar[boundary];
    auto t1 = std::chrono::high_resolution_clock::now();
    for(long long i=2; i<boundary; ++i) ar[i] = true;
    for(long long i=2; i<boundary; ++i) if(ar[i]) {
        long long j=i*2;
        while(j<boundary){
            ar[j] = false;
            j+=i;
        }
        counter++;
        prime_numbers.push(i);
    }
    auto t2 = std::chrono::high_resolution_clock::now();
    auto duration = std::chrono::duration_cast<std::chrono::milliseconds>(t2 - t1).count();
    std::cout << "Execution time for calculating prime numbers: " << duration << "ms\n\n";

    return prime_numbers;
}

int main(int argc, char *argv[]) {

    long long boundary = 8369999;   // Last allowance for my device's C++ implementation
    std::queue<long long> prime_numbers = get_prime_numbers(boundary),
                tmp_queue = prime_numbers;
    std::cout << "[  ";
    while(!tmp_queue.empty()) {
        std::cout << tmp_queue.front() << "  ";
        tmp_queue.pop();
    }
    std::cout << "]\n";

    return 0;
}
