#include <iostream>
#include  <queue>

/**
* @brief Gets all prime numbers ranging from 0 to a given boundary
*
* This function uses the sieve of Eratosthenes and the queue data structure.
* An array of all integers from 0 to the given boundary is generated with an assumption that all a prime numbers.
* Knowing that the integer 2 is the first prime number, all multiples of it from 0 to the given boundary are can-
* celled out. Any integer not cancelled out is a prime and hence stored in a queue. The process is repeated for
* all non-cancelled integers.
* Time complexity: O(n)
* Space complexity: O(n)
*
* @param boundary - long long
*
* @return prime_numbers - std::queue<long long>
*/
std::queue<long long> get_prime_numbers(long long boundary) {
    std::queue<long long> prime_numbers;
    int counter = 0;
    boundary+=1;
    bool ar[boundary];
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
