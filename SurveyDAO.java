import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurveyDAO {
    public void createSurvey(Survey survey) {
        String sql = "INSERT INTO surveys (title) VALUES (?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, survey.getTitle());
            pstmt.executeUpdate();

            // Assuming there is a method to retrieve the generated survey ID
            int surveyId = getGeneratedSurveyId();

            // Insert questions into the database
            for (Question question : survey.getQuestions()) {
                createQuestion(surveyId, question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createQuestion(int surveyId, Question question) {
        String sql = "INSERT INTO questions (survey_id, text, type) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, surveyId);
            pstmt.setString(2, question.getText());
            pstmt.setString(3, question.getType().name());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getGeneratedSurveyId() {
        // Logic to retrieve the generated survey ID from the database
        return 123; // Dummy value for demonstration
    }
}
