import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResponseDAO {
    public void submitResponse(Response response) {
        String sql = "INSERT INTO responses (survey_id, question_id, answer) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, response.getSurveyId());
            pstmt.setInt(2, response.getQuestionId());
            pstmt.setString(3, response.getAnswer());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
