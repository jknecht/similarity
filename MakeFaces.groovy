import static CarNames.carNames;
import static CarData.*;


// create faces based on acceleration, MPG, weight, horsepower

def maxAccel = carData.max{ it[ACCELERATION] }[ACCELERATION]
def minAccel = carData.min{ it[ACCELERATION] ?: maxAccel }[ACCELERATION]
def deltaAccel = maxAccel - minAccel

def maxMPG = carData.max{ it[MPG] }[MPG]
def minMPG = carData.min{ it[MPG] ?: maxMPG }[MPG]
def deltaMPG = maxMPG - minMPG

def maxWeight = carData.max{ it[WEIGHT] }[WEIGHT]
def minWeight = carData.min{ it[WEIGHT] ?: maxWeight }[WEIGHT]
def deltaWeight = maxWeight - minWeight

def maxHP = carData.max{ it[HORSEPOWER] }[HORSEPOWER]
def minHP = carData.min{ it[HORSEPOWER] ?: maxHP }[HORSEPOWER]
def deltaHP = maxHP - minHP

def attributeMappings = []
for (def attr : carData) {
	def map = []
	if (attr[ACCELERATION] <= minAccel + (deltaAccel * 1.0)) {
		map[0] = 4
	}
	if (attr[ACCELERATION] <= minAccel + (deltaAccel * 0.75)) {
		map[0] = 3
	}
	if (attr[ACCELERATION] <= minAccel + (deltaAccel * 0.5)) {
		map[0] = 2
	}
	if (attr[ACCELERATION] <= minAccel + (deltaAccel * 0.25)) {
		map[0] = 1
	}
	

	if (attr[MPG] <= minMPG + (deltaMPG * 1.0)) {
		map[1] = 4
	}
	if (attr[MPG] <= minMPG + (deltaMPG * 0.75)) {
		map[1] = 3
	}
	if (attr[MPG] <= minMPG + (deltaMPG * 0.5)) {
		map[1] = 2
	}
	if (attr[MPG] <= minMPG + (deltaMPG * 0.25)) {
		map[1] = 1
	}

	if (attr[WEIGHT] <= minWeight + (deltaWeight * 1.0)) {
		map[2] = 4
	}
	if (attr[WEIGHT] <= minWeight + (deltaWeight * 0.75)) {
		map[2] = 3
	}
	if (attr[WEIGHT] <= minWeight + (deltaWeight * 0.5)) {
		map[2] = 2
	}
	if (attr[WEIGHT] <= minWeight + (deltaWeight * 0.25)) {
		map[2] = 1
	}

	if (attr[HORSEPOWER] <= minHP + (deltaHP * 1.0)) {
		map[3] = 4
	}
	if (attr[HORSEPOWER] <= minHP + (deltaHP * 0.75)) {
		map[3] = 3
	}
	if (attr[HORSEPOWER] <= minHP + (deltaHP * 0.5)) {
		map[3] = 2
	}
	if (attr[HORSEPOWER] <= minHP + (deltaHP * 0.25)) {
		map[3] = 1
	}
	
	attributeMappings.add(map)
}

println(attributeMappings)
