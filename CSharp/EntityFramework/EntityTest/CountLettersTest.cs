using System.Collections.Generic;
using EntityFramework;
using NUnit.Framework;

namespace EntityTest
{
    [TestFixture]
    public class CountLettersTest
    {
        private Program testProgram;
        Dictionary<char, int> characterOccurence;

        [SetUp]
        public void Init()
        {
            testProgram = new Program();
        }
        
        [Test]
        public void TestWithPanama()
        {
            characterOccurence = testProgram.Count("Panama");

            Assert.AreEqual(3, characterOccurence['a']);
        }
        
        [Test]
        public void TestWithMississippi()
        {
            characterOccurence = testProgram.Count("Mississippi");

            Assert.AreEqual(4, characterOccurence['i']);
            Assert.AreEqual(4, characterOccurence['s']);
        }
        
        [Test]
        public void TestWithAlabama()
        {
            characterOccurence = testProgram.Count("Alabama");

            Assert.AreEqual(4, characterOccurence['a']);
        }
    }
}