package com.ltp.gradesubmission;

import com.ltp.gradesubmission.model.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;
import com.ltp.gradesubmission.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradesFromRepoTest(){
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
                new Grade("Harry", "Pot", "C"),
                new Grade("Her", "Art", "A")
        ));

        List<Grade> results = gradeService.getGrades();

        assertEquals("Harry", results.get(0).getName());
        assertEquals("Art", results.get(1).getSubject());
    }

    @Test
    public void gradeIndexTest(){
        Grade grade = new Grade("Harry", "Pot", "C");

        when(gradeRepository.getGrades())
                .thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0))
                .thenReturn(grade);

        int valid = gradeService.getGradeIndex(grade.getId());
        int notFound = gradeService.getGradeIndex("123");

        assertEquals(0, valid);
        assertEquals(Constants.NOT_FOUND, notFound);
    }

    @Test
    public void returnGradeByIdTest(){
        Grade grade = new Grade("Harry", "Pot", "C");

        when(gradeRepository.getGrades())
                .thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0))
                .thenReturn(grade);

        String id = grade.getId();
        Grade result = gradeService.getGradeById(id);
        assertEquals(result, grade);
    }

    @Test
    public void addGradeTest(){
        Grade grade = new Grade("Harry", "Pot", "C");

        when(gradeRepository.getGrades())
                .thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0))
                .thenReturn(grade);

        Grade newGrade = new Grade("Her", "Art", "A");
        gradeService.submitGrade(newGrade);

        verify(gradeRepository, times(1)).addGrade(newGrade);
    }

    @Test
    public void updateGradeTest(){
        Grade grade = new Grade("Harry", "Pot", "C");

        when(gradeRepository.getGrades())
                .thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0))
                .thenReturn(grade);

        grade.setScore("B");
        gradeService.submitGrade(grade);
        verify(gradeRepository, times(1)).updateGrade(grade, 0);
    }
}
