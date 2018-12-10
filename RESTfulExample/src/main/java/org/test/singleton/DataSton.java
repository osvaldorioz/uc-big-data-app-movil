package org.test.singleton;

import java.util.ArrayList;
import java.util.List;

import org.test.vo.GeolocVO;
import org.test.vo.PersonVO;

public class DataSton {
	public static final List<PersonVO> personas = new ArrayList<PersonVO>();
	public static final List<GeolocVO> locs     = new ArrayList<GeolocVO>();
}
