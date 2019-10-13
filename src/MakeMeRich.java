
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MakeMeRich {
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE",
			"AMZN", "CRAY", "CSCO", "SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN", "YHOO");

	public static void main(String[] args) {

		// 1. Print these symbols using a Java 8 for-each and lambdas
		// symbols.stream().forEach(System.out::println);
		// 2. Use the StockUtil class to print the price of Bitcoin
		// System.out.println(StockUtil.prices.get("BTC-$"));
		// 3. Create a new List of StockInfo that includes the stock price
		// List<Double> StockInfo =
		// StockUtil.prices.values().stream().collect(Collectors.toList());
		// 4. Find the highest-priced stock under $500
		List<StockInfo> listStockInfo = StockUtil.prices.entrySet().stream()
				.map(stock -> new StockInfo(stock.getKey(), stock.getValue())).collect(Collectors.toList());
		// listStockInfo.forEach(System.out::println);

		// 4. Find the highest-priced stock under $500
		StockInfo HPS = listStockInfo.stream().filter(StockUtil.isPriceLessThan(500)).reduce(StockUtil::pickHigh).get();
		;

		System.out.println(HPS.ticker + " is the highest priced stock under $500" + " with $" + HPS.price);

	}

}
