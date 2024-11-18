public class Server {




    
    public ArrayList<LocalDateTime> getConnectedTimes() {
        return new ArrayList<>(connectionTimes);
    }

    private List<Integer> calculateFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors.add(i);
        }
        return factors;
    }
}

