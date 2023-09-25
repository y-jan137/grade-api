package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        String[] utorids = gradeDB.getMyTeam().getMembers();
        float grade_sum = 0.0f;
        for (String utorid : utorids) {
            grade_sum += gradeDB.getGrade(utorid, course).getGrade();
        }
        return grade_sum / utorids.length;
    }
}
