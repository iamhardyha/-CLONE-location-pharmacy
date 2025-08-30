package me.devhardy.locationpharmacy.api.service

import me.devhardy.locationpharmacy.AbstractIntegrationContainerBaseTest
import me.devhardy.locationpharmacy.api.dto.KakaoApiResponseDto
import org.springframework.beans.factory.annotation.Autowired

class KakaoAddressSearchServiceTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private KakaoAddressSearchService kakaoAddressSearchService

    def "adress 파라미터 값이 null이면, requestAddressSearch 메소드는 null을 리턴한다."() {

        given:
        String adress = null

        when:
        def result = kakaoAddressSearchService.requestAddressSearch(adress)

        then:
        Objects.isNull(result)

    }

    def "주소값이 valid하다면, requestAddressSearch 메소드는 정상적으로 document를 반환한다."() {

        given:
        def address = "서울 성북구 중암로 10길"

        when:
        def result = kakaoAddressSearchService.requestAddressSearch(address)

        then:
        result.documentList.size() > 0
        result.metaDto.totalCount > 0
        result.documentList.get(0).addressName != null

    }
}
