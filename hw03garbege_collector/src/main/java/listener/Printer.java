package listener;

public class Printer {
    private static long listSize = 0, startTime = 0, totalMinorCollectionsTime = 0,
            totalMajorCollectionsTime = 0, numberOfMinorCleanings = 0,
            numberOfMajorCleanings = 0;

    public void print(String action, long duration) {
        double averageMinorCollectionTime = 0, averageMajorCollectionTime = 0;
        if (action.equals("end of minor GC")) {
            numberOfMinorCleanings++;
            totalMinorCollectionsTime += duration;
            averageMinorCollectionTime = totalMinorCollectionsTime / (double)numberOfMinorCleanings;
        } else if (action.equals("end of major GC")) {
            numberOfMajorCleanings++;
            totalMajorCollectionsTime += duration;
            averageMajorCollectionTime = totalMajorCollectionsTime / (double)numberOfMajorCleanings;
        }

        System.out.printf("%-20d%-20d%-20.3f%-20d%-20d%-20.3f%-20d%.3f\n",
                numberOfMinorCleanings, totalMinorCollectionsTime, averageMinorCollectionTime,
                numberOfMajorCleanings, totalMajorCollectionsTime, averageMajorCollectionTime,
                listSize, (System.currentTimeMillis() - startTime) / 60000.0);
    }

    public static void setStartTime(long startTime) {
        Printer.startTime = startTime;
    }

    public  static void setListSize(long listSize) {
        Printer.listSize = listSize;
    }
}
