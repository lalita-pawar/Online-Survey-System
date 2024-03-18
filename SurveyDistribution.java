import java.util.UUID;

public class SurveyDistribution {
    public String generateSurveyLink(int surveyId, int userId) {
        // Generate a unique survey link with UUID
        String uniqueKey = UUID.randomUUID().toString();

        // Save the link to the database
        saveSurveyLinkToDatabase(surveyId, userId, uniqueKey);

        return "https://yourwebsite.com/survey?id=" + uniqueKey;
    }

    private void saveSurveyLinkToDatabase(int surveyId, int userId, String uniqueKey) {
        // Logic to save the survey link to the database
    }
}
