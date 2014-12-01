package auxiliares;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;

public class AuxVideoURL {

	private List<String> misVideos;

	public AuxVideoURL() {
	}

	@SuppressLint("DefaultLocale")
	public String getVideoURL(int pos, String deporte) {
		deporte = deporte.toLowerCase();

		if (deporte.equals("correr")) {
			if (pos == 1) {
				return "https://www.youtube.com/watch?v=qHmCzn0lRsE";
			} else if (pos == 2) {
				return "https://www.youtube.com/watch?v=FbI0zJRid_Y";
			} else {
				return "https://www.youtube.com/watch?v=_bV2RDM7EWI";
			}
		} else if (deporte.equals("natacion")) {
			if (pos == 1) {
				return "https://www.youtube.com/watch?v=ejj9g024ug4";
			} else if (pos == 2) {
				return "https://www.youtube.com/watch?v=Y5WHIGIFzdU";
			} else {
				return "https://www.youtube.com/watch?v=R8XAdsQfKbE";
			}

		} else if (deporte.equals("caminar")) {
			if (pos == 1) {
				return "https://www.youtube.com/watch?v=IbvnLm_qdcE";
			} else if (pos == 2) {
				return "https://www.youtube.com/watch?v=Sny_d-n6EM8";
			} else {
				return "https://www.youtube.com/watch?v=CF_hA4YETgo";
			}

		} else if (deporte.equals("spinning")) {
			if (pos == 1) {
				return "https://www.youtube.com/watch?v=lFbjsRvjF-A";
			} else if (pos == 2) {
				return "https://www.youtube.com/watch?v=NOpbiP3mkJ0";
			} else {
				return "https://www.youtube.com/watch?v=RvgFh6hhnKE";
			}
		} else if (deporte.equals("baloncesto")) {
			if (pos == 1) {
				return "https://www.youtube.com/watch?v=fzHK-XDzWBk";
			} else if (pos == 2) {
				return "https://www.youtube.com/watch?v=v5Nzp1ozXi4";
			} else {
				return "https://www.youtube.com/watch?v=2dTq-qq3CFA";
			}
		} else if (deporte.equals("futbol")) {
			if (pos == 1) {
				return "https://www.youtube.com/watch?v=p6cjn-ogrIc";
			} else if (pos == 2) {
				return "https://www.youtube.com/watch?v=G3fw8AOK1QU";
			} else {
				return "https://www.youtube.com/watch?v=R3JvETM8KjI";
			}
		} else if (deporte.equals("atletismo")) {
			if (pos == 1) {
				return "https://www.youtube.com/watch?v=QAkuSiHROSY";
			} else if (pos == 2) {
				return "https://www.youtube.com/watch?v=sGMU5L6g6Gs";
			} else {
				return "https://www.youtube.com/watch?v=bb-Q7_jnwg8";
			}
		}

		return "";

	}

	public List<String> getLista(String name) {
		final String DEPORTES[] = { "Correr", "Caminar", "Spinning",
				"Baloncesto", "Futbol", "Natacion", "Atletismo" };
		misVideos = new ArrayList<String>();

		if (name.equals(DEPORTES[0])) {
			misVideos.add("Beneficios del correr - ejercicio");
			misVideos
					.add("Entrena con Serrano. Cómo empezar a correr. Capítulo 1");
			misVideos.add("Running is Life Correr es vida");
		} else if (name.equals(DEPORTES[1])) {
			misVideos
					.add("Marcha atlética - Ejercicios de adaptación a la técnica");
			misVideos.add("Caminar Adelgaza - 5 Beneficios");
			misVideos.add("Once Noticias- Ejercicios de caminata");
		} else if (name.equals(DEPORTES[2])) {
			misVideos
					.add("Spinning® Workout - Get Fit With GCN's 60 Minute Spin Class");
			misVideos
					.add("Fat Burning Workout - 40 Minute Indoor Cycling Class");
			misVideos
					.add("spinning 1 in door giovanni carrasco altamirano clase completa todos los niveles");
		} else if (name.equals(DEPORTES[3])) {
			misVideos.add("Fundamentos técnicos del basquetbol");
			misVideos.add("5 trucos para ser bueno en Basket");
			misVideos
					.add("Michael Jordan enseña tecnicas y formas de mejorar los tiros libres");
		} else if (name.equals(DEPORTES[4])) {
			misVideos.add("Learn Amazing Football Skills Tutorial ");
			misVideos.add("Giro doble toque | Truco de Fútbol ");
			misVideos.add("Trucos de Futbol Sala & jugadas de futbol ");
		} else if (name.equals(DEPORTES[5])) {
			misVideos.add("Iniciación a la Natación.");
			misVideos
					.add("Natación - Cómo se debe respirar en el estilo Libre");
			misVideos.add("5 - Ejercicios de natación");
		} else if (name.equals(DEPORTES[6])) {
			misVideos.add("Técnica Atletismo - Completa");
			misVideos.add("Técnica Atletismo - 10 puntos importantes");
			misVideos.add("metodologia atletismo velocidad");
		}

		return misVideos;
	}
}
