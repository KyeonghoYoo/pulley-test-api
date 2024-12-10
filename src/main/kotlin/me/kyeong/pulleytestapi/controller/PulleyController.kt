package me.kyeong.pulleytestapi.controller

import me.kyeong.pulleytestapi.dto.request.ProblemSearchCondition
import me.kyeong.pulleytestapi.dto.request.WorkBookCreateRequest
import me.kyeong.pulleytestapi.dto.response.ProblemResponse
import me.kyeong.pulleytestapi.dto.response.WorkbookResponse
import me.kyeong.pulleytestapi.service.PulleyService
import me.kyeong.pulleytestapi.util.ApiResult
import me.kyeong.pulleytestapi.util.ApiStatus
import me.kyeong.pulleytestapi.util.logger
import me.kyeong.pulleytestapi.util.success
import org.springframework.web.bind.annotation.*

@RestController
class PulleyController(
    val pulleyService: PulleyService
) {
    val log = logger()

    /**
     * 문제 조회
     */
    @GetMapping("/problems")
    fun getProblems(
        @ModelAttribute searchCondition: ProblemSearchCondition
    ): ApiResult<ProblemResponse> {
        return success(pulleyService.getProblems(searchCondition))
    }

    /**
     * 학습지 생성
     */
    @PostMapping("/piece")
    fun createWorkbook(
        @RequestBody request: WorkBookCreateRequest
    ): ApiResult<WorkbookResponse> {
        return success(response = pulleyService.createWorkbook(request), apiStatus = ApiStatus.CREATED)
    }

    /**
     * 학생에게 학습지 출제하기
     */
    @PostMapping("/piece/{pieceId}")
    fun setWorkbook(
        @PathVariable pieceId: Long,
        @RequestParam studentIds: List<Long>
    ): ApiResult<Unit> {
        pulleyService.setWorkbook(pieceId, studentIds)
        return success(apiStatus = ApiStatus.CREATED)
    }

    /**
     * 학습지의 문제 조회하기
     */
    @GetMapping("/piece/problems")
    fun getProblemsInWorkbook() {
        // TODO 로직 작성 예정
    }

    /**
     * 채점하가
     */
    @PutMapping("/piece/problems")
    fun gradeWorkbook(@RequestBody pieceId: String) {
        // TODO 로직 작성 예정
    }

    /**
     * 학습지 학습 통계 분석하기
     */
    @GetMapping("/piece/analyze")
    fun getAnalyzeOfWorkbook() {
        // TODO 로직 작성 예정
    }
}