package main.java.ch.start.uebungen;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LearningLambda {

	final static Logger logger = LoggerFactory.getLogger(LearningLogback.class);

	public static void main(String[] args) {

		// nimm das File aus dem Resourcen Ordner
		String currentUserDirString = System.getProperty("user.dir");
		String filePathString = currentUserDirString + "/src/main/resources";

		Path positionFilePath = Paths.get(filePathString, "positions.csv");
		logger.info("Read file: " + positionFilePath.toAbsolutePath());

		// oeffne einen BufferedReader, um Zeile fuer Zeile aus der Datei zu lesen
		try (var fileBufferedReader = Files.newBufferedReader(positionFilePath)) {

			// lese jede einzelne Zeile und wandel sie in ein Objekt der Klasse FileEntry um
			String lineInFile = fileBufferedReader.readLine();
			int countLines = 0;
			while (lineInFile != null) {
				logger.info(countLines + ": " + lineInFile);
				if (countLines > 0) {
					String[] lineAsStringArray = lineInFile.split(",");
					FileEntry fileEntry = new FileEntry();
					for (int iInLine = 0; iInLine < lineAsStringArray.length; iInLine++) {
						String lineEntry = lineAsStringArray[iInLine];
						logger.info(" -> " + iInLine + ": " + lineEntry);
						// ignoriere die erste Zeile, das ist nur der Header
						switch (iInLine) {
						case 0:
							fileEntry.positionNumber = new BigDecimal(lineEntry); break;
						case 1:
							fileEntry.iban = lineEntry; break;
						case 2:
							fileEntry.quantity = new BigDecimal(lineEntry); break;
						case 3:
							fileEntry.currency = lineEntry; break;
						case 4:
							fileEntry.owner = lineEntry; break;
						case 5:
							fileEntry.orderNumber = new BigDecimal(lineEntry); break;
						case 6:
							fileEntry.orderType = lineEntry; break;
						default:
							logger.error("Entry " + iInLine + " is not supported: " + lineEntry);
						}

					}
					logger.info("Generated new FileEntry: " + fileEntry.toString());
				}
				lineInFile = fileBufferedReader.readLine();
				countLines++;

			}
		} catch (IOException ioException) {
			// falls die Dateiverarbeitung nicht funktioniert, logge die Informationen aus,
			// was dabei schief gegangen ist
			logger.error("IOException while reading file: " + positionFilePath.toAbsolutePath());
			logger.error("IOException " + ioException.toString());

			// gebe den Punkt aus, an dem es schief gelaufen ist
			StackTraceElement[] elements = ioException.getStackTrace();
			for (int i = 1; i < elements.length; i++) {
				StackTraceElement s = elements[i];
				logger.error("\tat " + s.getClassName() + "." + s.getMethodName() + "("
						+ s.getFileName() + ":" + s.getLineNumber() + ")");

			}

		}

	}

}
