using EntityFramework;
using NUnit.Framework;

namespace EntityTest
{
    [TestFixture]
    public class AnagramTests
    {
        private Program testProgram;

        [SetUp]
        public void Init()
        {
            testProgram = new Program();
        }
        
        [Test]
        public void TestWithMonica()
        {
            Assert.True(testProgram.areAnagrams("Monica Lewinsky", "Nice Silky Woman"));
        }
        
        [Test]
        public void TestWithMachines()
        {
            Assert.True(testProgram.areAnagrams("Slot Machines", "Cash lost in me"));
        }
        
        [Test]
        public void TestWithThirteen()
        {
            Assert.True(testProgram.areAnagrams("Eleven plus Two", "Twelve plus One"));
        }

        [Test]
        public void TestWithBanderas()
        {
            Assert.True(testProgram.areAnagrams("Antonio Banderas", "No brains on a date"));
        }

        [Test]
        public void TestWithEastwood()
        {
            Assert.True(testProgram.areAnagrams("Clint Eastwood", "Old West action"));
        }

        [Test]
        public void TestWithElvis()
        {
            Assert.True(testProgram.areAnagrams("Elvis", "lives"));
        }
    }
}