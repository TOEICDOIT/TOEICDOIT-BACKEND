package site.toeicdoit.tx.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
@ToString(exclude = {"id"})
public class ResultModel extends BaseModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userAnswer;
    private boolean isCorrect; //정답유무
    private String timeElasped; //풀이시간
    private String score; //점수
    private String lcScore; //lc점수
    private String rcScore; //rc점수


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ToeicCategoryModel toeicCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ResultModel parentId;

    @OneToMany(mappedBy = "parentId", orphanRemoval = true)
    private List<ResultModel> childrenIds;

}