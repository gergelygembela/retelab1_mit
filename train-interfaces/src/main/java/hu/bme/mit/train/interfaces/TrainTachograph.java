package hu.bme.mit.train.interfaces;

public interface TrainTachograph {
	void logData();
	com.google.common.collect.Table<java.util.Date, Integer, Integer> getHistory();
}
