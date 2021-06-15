package nextstep.subway.map.application;

import static net.logstash.logback.argument.StructuredArguments.*;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.lang.Collections;
import nextstep.subway.line.application.LineService;
import nextstep.subway.line.domain.Line;
import nextstep.subway.map.domain.SubwayPath;
import nextstep.subway.map.dto.PathResponse;
import nextstep.subway.map.dto.PathResponseAssembler;
import nextstep.subway.station.application.StationService;
import nextstep.subway.station.domain.Station;

@Service
@Transactional
public class MapService {

    private final Logger log = LoggerFactory.getLogger("json");
    private LineService lineService;
    private StationService stationService;
    private PathService pathService;

    public MapService(LineService lineService, StationService stationService, PathService pathService) {
        this.lineService = lineService;
        this.stationService = stationService;
        this.pathService = pathService;
    }

    public PathResponse findPath(Long source, Long target) {
        List<Line> lines = lineService.findLines();
        Station sourceStation = stationService.findById(source);
        Station targetStation = stationService.findById(target);
        SubwayPath subwayPath = pathService.findPath(lines, sourceStation, targetStation);

        log.info("Find a path from {} to {} = {} ({})",
            kv("source", sourceStation.getName()),
            kv("target", targetStation.getName()),
            kv("distance", subwayPath.calculateDistance()),
            kv("stations", subwayPath.getStations().stream().map(Station::getName).collect(Collectors.toList())));

        return PathResponseAssembler.assemble(subwayPath);
    }
}
