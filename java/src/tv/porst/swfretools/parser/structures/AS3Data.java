package tv.porst.swfretools.parser.structures;

import tv.porst.splib.binaryparser.IFileElement;
import tv.porst.splib.binaryparser.UINT16;
import tv.porst.swfretools.parser.SWFParserHelpers;

public class AS3Data implements IFileElement {

	private final UINT16 minorVersion;

	private final UINT16 majorVersion;

	private final ConstantPool constantPool;

	private final EncodedU30 methodCount;

	private final MethodInfoList methodInfos;

	private final EncodedU30 metaDataCount;

	private final MetaDataList metaData;

	private final EncodedU30 classCount;

	private final InstanceInfoList instances;

	private final ClassInfoList classes;

	private final EncodedU30 scriptCount;

	private final ScriptInfoList scripts;

	private final EncodedU30 methodBodyCount;

	private final MethodBodyList methodBodies;

	public AS3Data(final UINT16 minorVersion, final UINT16 majorVersion, final ConstantPool constantPool,
			final EncodedU30 methodCount, final MethodInfoList methodInfos, final EncodedU30 metaDataCount,
			final MetaDataList metaData, final EncodedU30 classCount, final InstanceInfoList instances,
			final ClassInfoList classes, final EncodedU30 scriptCount, final ScriptInfoList scripts,
			final EncodedU30 methodBodyCount, final MethodBodyList methodBodies) {

		this.minorVersion = minorVersion;
		this.majorVersion = majorVersion;
		this.constantPool = constantPool;
		this.methodCount = methodCount;
		this.methodInfos = methodInfos;
		this.metaDataCount = metaDataCount;
		this.metaData = metaData;
		this.classCount = classCount;
		this.instances = instances;
		this.classes = classes;
		this.scriptCount = scriptCount;
		this.scripts = scripts;
		this.methodBodyCount = methodBodyCount;
		this.methodBodies = methodBodies;
	}
	@Override
	public int getBitLength() {
		return SWFParserHelpers.addBitLengths(minorVersion, majorVersion, constantPool, methodCount,
				methodInfos, metaDataCount, metaData, classCount, instances, classes, scriptCount,
				scripts, methodBodyCount, methodBodies);
	}
	@Override
	public int getBitPosition() {
		return minorVersion.getBitPosition();
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getClassCount() {
		return classCount;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public ClassInfoList getClasses() {
		return classes;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public ConstantPool getConstantPool() {
		return constantPool;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public InstanceInfoList getInstances() {
		return instances;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getMajorVersion() {
		return majorVersion;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public MetaDataList getMetaData() {
		return metaData;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getMetaDataCount() {
		return metaDataCount;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public MethodBodyList getMethodBodies() {
		return methodBodies;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getMethodBodyCount() {
		return methodBodyCount;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getMethodCount() {
		return methodCount;
	}
	/**
	 * Returns the
	 *
	 * @return The
	 */
	public MethodInfoList getMethodInfos() {
		return methodInfos;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public UINT16 getMinorVersion() {
		return minorVersion;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public EncodedU30 getScriptCount() {
		return scriptCount;
	}

	/**
	 * Returns the
	 *
	 * @return The
	 */
	public ScriptInfoList getScripts() {
		return scripts;
	}

}
