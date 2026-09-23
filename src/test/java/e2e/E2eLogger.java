package e2e;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public final class E2eLogger {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    private E2eLogger() {}

    public static void log(String name, String method, String path, Object payload, Object response, String result, int status) {
        String safe = name.toUpperCase().replaceAll("[^A-Z0-9]+", "_");
        Path dir = Paths.get("tests", "e2e", "logs", safe);
        try {
            Files.createDirectories(dir);
            String ts = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path file = dir.resolve(safe + "_" + ts + ".log");
            StringBuilder sb = new StringBuilder();
            sb.append("=".repeat(70)).append("\n");
            sb.append("TESTE: ").append(method).append(" ").append(path).append("\n");
            sb.append("DATA: ").append(OffsetDateTime.now()).append("\n");
            sb.append("=".repeat(70)).append("\n\n");
            sb.append("--- PAYLOAD (enviado) ---\n").append(enc(payload)).append("\n\n");
            sb.append("--- RESPOSTA (saida do SDK) ---\n").append("HTTP: ").append(status).append("\n").append(enc(response)).append("\n\n");
            sb.append("--- RESULTADO ---\n").append(result).append("\n");
            Files.write(file, sb.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String enc(Object v) {
        if (v == null) return "(sem dados)";
        try {
            return GSON.toJson(v);
        } catch (RuntimeException e) {
            return String.valueOf(v);
        }
    }
}